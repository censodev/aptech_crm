package com.aptech.crm.cli.classroom;

import com.aptech.crm.cli.Cli;
import com.aptech.crm.data.domains.Student;
import com.aptech.crm.dto.classroom.ClassRegistrationDTO;
import com.aptech.crm.services.AuthService;
import com.aptech.crm.services.ClassroomService;
import com.aptech.crm.utils.BeanUtil;
import com.aptech.crm.utils.CliUtil;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClassLeaveCli implements Cli {
    private final ClassroomService service = BeanUtil.getBean(ClassroomService.class);
    private final AuthService auth = BeanUtil.getBean(AuthService.class);

    @Override
    public String getLabel() {
        return "Hủy đăng ký lớp";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        var dataset = service.findClassRegistrationsByStudentId(auth.getAuthStd().map(Student::getId).orElse(null));
        var titles = new String[]{"ID", "Tên học phần", "Ngày bắt đầu", "Ngày kết thúc", "Phòng học", "Môn học", "Giảng viên", "Thời gian đăng ký", "Trạng thái", "Tên học viên"};
        CliUtil.printTable(titles, dataset, ClassRegistrationDTO.class);
        System.out.print("Chọn mã lớp học phần muốn hủy đăng ký: ");
        var scanner = new Scanner(System.in);
        var classId = Long.parseLong(scanner.nextLine());
        var stdId = auth.getAuthStd().map(Student::getId).orElse(null);
        if (service.leave(stdId, classId)) {
            System.out.println("Hủy đăng ký lớp thành công");
        } else {
            System.out.println("Không thể hủy đăng ký lớp");
        }
    }
}
