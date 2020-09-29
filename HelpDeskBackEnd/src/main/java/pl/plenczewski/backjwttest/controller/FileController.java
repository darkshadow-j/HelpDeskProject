package pl.plenczewski.backjwttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.plenczewski.backjwttest.models.ticket.TicketAttachments;
import pl.plenczewski.backjwttest.services.ticket.FileService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("{ticketID}")
    public void uploadFile(@RequestBody List<MultipartFile> file, @PathVariable("ticketID") String ticketID) throws IOException {
        List<TicketAttachments> attachments = new ArrayList<>();
        for (MultipartFile onefile: file) {
            attachments.add(new TicketAttachments(onefile.getOriginalFilename(), onefile.getContentType(),
                    compressBytes(onefile.getBytes())));
        }
        fileService.uploadFile(attachments, ticketID);

    }

    @GetMapping("{ticketID}")
    public List<TicketAttachments> getImage(@PathVariable("ticketID") String ticketID) {
        List<TicketAttachments> ta = new ArrayList<>();
        for(TicketAttachments zal: fileService.findByTicketID(Long.valueOf(ticketID))){
            ta.add(new TicketAttachments(zal.getName(), zal.getType(),
                    decompressBytes(zal.getPicByte())));
        }
        return ta;
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        } catch (DataFormatException e) {
            System.err.println(e);
        }
        return outputStream.toByteArray();
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        System.err.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

}
