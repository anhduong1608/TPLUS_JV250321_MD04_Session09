import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("********QUẢN LÝ SINH VIÊN*********");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tìm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                    addStudents();
                    break;
                case 3:
                    updateStudentById();
                    break;
                case 4:
                    deleteStudentById();
                    break;
                case 5:
                    searchStudentByName();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 6);
    }

    private static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng.");
        } else {
            System.out.println("Danh sách sinh viên:");
            for (Student st : studentList) {
                st.displayData();
            }
        }
    }

    private static void addStudents() {
        System.out.print("Nhập số lượng sinh viên cần thêm: ");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            Student st = new Student();
            st.inputData(scanner);
            studentList.add(st);
        }
    }

    private static void updateStudentById() {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String id = scanner.nextLine();
        Student found = findById(id);
        if (found != null) {
            System.out.println("Nhập thông tin mới:");
            found.inputData(scanner);
            System.out.println("Cập nhật thành công.");
        } else {
            System.out.println("Mã sinh viên không tồn tại.");
        }
    }

    private static void deleteStudentById() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();
        Student found = findById(id);
        if (found != null) {
            studentList.remove(found);
            System.out.println("Xóa sinh viên thành công.");
        } else {
            System.out.println("Mã sinh viên không tồn tại.");
        }
    }

    private static void searchStudentByName() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        List<Student> result = new ArrayList<>();
        for (Student st : studentList) {
            if (st.getStudentName().toLowerCase().contains(name)) {
                result.add(st);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào.");
        } else {
            System.out.println("Danh sách sinh viên tìm thấy:");
            for (Student st : result) {
                st.displayData();
            }
            System.out.println("Tổng số sinh viên tìm thấy: " + result.size());
        }
    }

    private static Student findById(String id) {
        for (Student st : studentList) {
            if (st.getStudentId().equalsIgnoreCase(id)) {
                return st;
            }
        }
        return null;
    }
}
