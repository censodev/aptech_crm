package com.aptech.usm.cli.classroom;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Student;
import com.aptech.usm.services.ClassroomService;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClassroomDetailsCli implements Cli {
    private final ClassroomService service = BeanUtil.getBean(ClassroomService.class);

    @Override
    public String getLabel() {
        return "Thông tin chi tiết lớp học phần";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        System.out.print("Nhập ID lớp học phần: ");
        var scanner = new Scanner(System.in);
        var id = Long.parseLong(scanner.nextLine());
        var dataset = service.findStudentsByClassId(id);
        var titles = new String[]{"ID", "Họ tên", "CCCD", "Ngày sinh", "Điện thoại", "Email"};
        CliUtil.printTable(titles, dataset, Student.class);
    }
}
