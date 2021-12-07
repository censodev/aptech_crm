package com.aptech.usm.cli.subject;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Subject;
import com.aptech.usm.data.repositories.SubjectRepository;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubjectCreateCli implements Cli {
    @Override
    public String getLabel() {
        return "Tạo mới môn học";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        var subject = new Subject();
        System.out.print("Tên môn: ");
        subject.setName(scanner.nextLine());
        System.out.print("Số tín chỉ: ");
        subject.setCredits(Integer.parseInt(scanner.nextLine()));
        var titles = new String[]{"ID", "Tên môn", "Số tín chỉ"};
        CliUtil.printRecord(titles, subject, Subject.class);
        System.out.println("Bạn muốn tạo mới môn học? (y/n)");
        if (scanner.nextLine().equals("y")) {
            BeanUtil.getBean(SubjectRepository.class).save(subject);
            System.out.println("Tạo mới môn học thành công");
        }
    }
}
