## CSD201 - LAB 1

### Hiện thực 2 bài toán sau:

1. Một mobile game có **khoảng 1000** người chơi, thông tin cần lưu trữ người chơi bao gồm email và point (điểm số), hãy **tự xây dựng** một cấu trúc dữ liệu (thông qua các kiến thức đã học) giúp thực hiện các chức năng quản lý thông tin người chơi **một cách hiệu quả**. Các chức năng cần để quản lý thông tin người chơi bao gồm: thêm (add), xóa (delete), sửa (update) và tìm kiếm (get). Yêu cầu độ phức tạp của giải thuật khi thực hiện các chức năng phải đạt **yêu cầu tối thiểu** là **O(N)**, riêng với chức năng tìm kiếm và xóa ứng với **người chơi có điểm số cao nhất** có độ phức tạp là **O(1)**.
2. Xây dựng một cấu trúc dữ liệu **stack dựa trên array** với các thao tác **pop** và **push** có độ phức tạp là **O(1)**. Sử dụng cấu trúc stack vừa được xây dựng truy xuất đến một website bất kỳ (ví dụ: vnexpress.net) và **thống kê số html TAG** được sử dụng trong website đó. Dữ liệu thống kê sẽ được ghi vào file CSV với thứ tự các tag tương ứng tần suất xuất hiện của nó từ cao đến thấp.

### Các yêu cầu trong LAB

1. Chương trình được viết trên mô hình OOP. Học viên được yêu cầu sử dụng try, catch và exception để handle Error. 

2. Sử dụng công nghệ GIT để quản mã nguồn, ứng với mỗi hàm được viết mới hoặc cập nhật, học viên được yêu cầu phải thực hiện commit. Mã nguồn phải được xuất bản trên Github và lịch sử phát triển của mã nguồn phải thể hiện được quá trình liên tục.

3. Với mỗi phương thức (method) và lớp (class), học viên đều buộc phải viết ghi chú dưới dạng chuẩn Java Doc - HTML (xem thêm tại https://www.tutorialspoint.com/java/java_documentation.htm). Các tag yêu cầu bao gồm: param, returns, exception và phần summary.

4. Ứng dụng cung cấp giao diện dòng lệnh cơ bản CLI, hổ trợ các cú pháp sau:
   ```
   # Hướng dẫn sử dụng
   ./lab1 -h
   Help: 
   ./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file
   ./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file
   ./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file
   ./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file
   ./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file
   ./lab1 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre
   ./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre

   ./lab1 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file
   ```
5. Chuẩn đầu vào và đầu ra của ứng dụng
   
   ```
   # USER CSV FILE
   Email, Point
   abcv203@gmail.com, 250
   febgulinda8@outlook.com, 30
   thinkerabc@yahoo.com, 356
   ...

   # OUTPUT CSV FILE
   Tag, Frequence
   div, 523
   img, 34
   li, 12
   ...
   ```
6. Các ghi chú, tóm lược và  điểm nỗi bật của trong project của học viên được trình bày trong file README.md bằng ngôn ngữ markdown.

**Deadline:** 23h00 14/06/2020. Sau deadline mọi commit sẽ không được xem xét. 

**NOTE**: Các yêu cầu 1 và 6 là tiên quyết, giảng viên sẽ loại những dự án không đảm bảo các yêu cầu này. Điểm số xác định bằng số testcase mà ứng dụng của học viên có thể vượt qua. Tất cả các source code được phần mềm phân tích là sao chép sẽ bị cấm thi. 
