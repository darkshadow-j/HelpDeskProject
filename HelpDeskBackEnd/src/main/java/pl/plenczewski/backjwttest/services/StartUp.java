package pl.plenczewski.backjwttest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.plenczewski.backjwttest.models.ERole;
import pl.plenczewski.backjwttest.models.Role;
import pl.plenczewski.backjwttest.models.User;
import pl.plenczewski.backjwttest.models.stats.Statistic;
import pl.plenczewski.backjwttest.models.stats.SubCategoryWithColor;
import pl.plenczewski.backjwttest.models.ticket.Category;
import pl.plenczewski.backjwttest.models.ticket.Subcategory;
import pl.plenczewski.backjwttest.repository.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StartUp {

    SubCategoryRepository subCategoryRepository;
    CategoryRepository categoryRepository;
    RoleRepository roleRepository;
    UserRepository userRepository;
    StatisticRepository statisticRepository;
    SubCategoryWithColorRepository subCategoryWithColorRepository;

    @Autowired
    public StartUp(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository, RoleRepository roleRepository, UserRepository userRepository, StatisticRepository statisticRepository, SubCategoryWithColorRepository subCategoryWithColorRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.statisticRepository = statisticRepository;
        this.subCategoryWithColorRepository = subCategoryWithColorRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void prepareData(){

        Subcategory subcategory = new Subcategory();
        subcategory.setSubcategoryName("Otago");
        subCategoryRepository.save(subcategory);
        Subcategory subcategory2 = new Subcategory();
        subcategory2.setSubcategoryName("EwMapa");
        subCategoryRepository.save(subcategory2);
        List<Subcategory> subcategoryList = new ArrayList<>();
        subcategoryList.add(subcategory);
        subcategoryList.add(subcategory2);

        Subcategory subcategoryy = new Subcategory();
        subcategoryy.setSubcategoryName("Drukarka");
        subCategoryRepository.save(subcategoryy);
        Subcategory subcategoryy2 = new Subcategory();
        subcategoryy2.setSubcategoryName("Monitor");
        subCategoryRepository.save(subcategoryy2);
        List<Subcategory> subcategoryyList = new ArrayList<>();
        subcategoryyList.add(subcategoryy);
        subcategoryyList.add(subcategoryy2);

        Category category = new Category();
        category.setCategoryName("Programy");
        category.setSubcategories(subcategoryList);
        categoryRepository.save(category);

        Category category2 = new Category();
        category2.setCategoryName("Sprzet");
        category2.setSubcategories(subcategoryyList);
        categoryRepository.save(category2);

        System.out.println("READY");



        Role role = new Role();
        role.setName(ERole.ROLE_USER);
        roleRepository.save(role);

        Role role2 = new Role();
        role2.setName(ERole.ROLE_MODERATOR);
        roleRepository.save(role2);

        Role role3 = new Role();
        role3.setName(ERole.ROLE_ADMIN);
        roleRepository.save(role3);

        Set<Role> rolex = new HashSet<>();
        rolex.add(role);
        rolex.add(role2);
        rolex.add(role3);

        User user = new User();
        user.setImie("Pawel Lenczewski");
        user.setEmail("lllaa@wp.pl");
        user.setUsername("admin");
        user.setPassword("$2a$10$c/C7ovDoyJu8eh0ACaqTaO3xFk4Kgp9xkFMYVO6ol4BZ9Zsoch9U6");
        user.setRoles(rolex);
        userRepository.save(user);

        SubCategoryWithColor subCategoryWithColor = new SubCategoryWithColor();
        subCategoryWithColor.setColor("RED");
        subCategoryWithColor.setSubCategoryList(subcategory);
        subCategoryWithColor.setValue(60);

        SubCategoryWithColor subCategoryWithColor2 = new SubCategoryWithColor();
        subCategoryWithColor2.setColor("BLUE");
        subCategoryWithColor2.setSubCategoryList(subcategory2);
        subCategoryWithColor2.setValue(30);

        SubCategoryWithColor subCategoryWithColor3 = new SubCategoryWithColor();
        subCategoryWithColor3.setColor("BLUE");
        subCategoryWithColor3.setSubCategoryList(subcategoryy);
        subCategoryWithColor3.setValue(10);

        List<SubCategoryWithColor> subCategoryWithColorList = new ArrayList<>();
        subCategoryWithColorList.add(subCategoryWithColor);
        subCategoryWithColorList.add(subCategoryWithColor2);
        subCategoryWithColorList.add(subCategoryWithColor3);

        Statistic statistic = new Statistic();
        statistic.setNameStatistic("Testowa");
        statistic.setSubCategoryWithColor(subCategoryWithColorList);
        statisticRepository.save(statistic);

    }

}
