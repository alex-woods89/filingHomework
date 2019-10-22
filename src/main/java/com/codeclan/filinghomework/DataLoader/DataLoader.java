package com.codeclan.filinghomework.DataLoader;

import com.codeclan.filinghomework.models.File;
import com.codeclan.filinghomework.models.Folder;
import com.codeclan.filinghomework.models.User;
import com.codeclan.filinghomework.repositories.FileRepository;
import com.codeclan.filinghomework.repositories.FolderRepository;
import com.codeclan.filinghomework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public void run(ApplicationArguments args){


        User user1 = new User("John");
        userRepository.save(user1);

        Folder folder1 = new Folder("fun folder", user1);
        Folder folder2 = new Folder("Extra fun folder", user1);
        folderRepository.save(folder1);
        folderRepository.save(folder2);

        File file1 = new File("file1", ".rb", 3, folder1);
        fileRepository.save(file1);



        folder1.addFiles(file1);
        user1.addFolders(folder1);
    }
}
