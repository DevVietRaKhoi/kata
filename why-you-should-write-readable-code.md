# Sống bằng nghề viết trong thế kỷ XXI: Code

Nếu ai đó tự giới thiệu sống bằng nghề viết thì chắc hẳn mọi nguời sẽ nghĩ anh chàng hay cô nàng ấy là nhà văn hay nhà báo. Nhưng ngày nay người đó lại là kỹ sư phần mềm. Việc viết code trở thành nghề giao tiếp với máy tính và thông ngôn giữa người sử dụng, khách hàng, product manager và với hệ thống máy tính.

Nghĩ được như vậy đã hay, nhưng chưa đủ. Kỹ sư phần mềm không còn một mình một chiếu mà làm theo nhóm và bạn phải viết code sao cho người khác cũng hiểu chứ không chỉ cái máy tính đọc đuợc. Sau đây là những hệ luỵ nếu bạn không thể viết code sao cho người khác hiểu:

1. Bạn không thể làm việc theo nhóm. Viết code tệ cũng như người hôi hám vậy, chả ai muốn ở gần

2. Bạn không thể chuyển giao code cho người khác một cách suôn sẻ và phải ôm nó cho đến khi bỏ việc

3. Bạn không thể dạy đệ tử và junior vì không ai hiểu những dòng code vi diệu của bạn

4. Bạn không thể nổi tiếng vì chả ai thèm đọc code của bạn vì quá khó hiểu và khó refactor

## Vậy làm sao để người khác hiểu code của bạn?

Sau đây là những điều nên làm, chia theo các cấp độ từ lính trơn khi bạn mới học code cho đến khi thành senior:

1. Có code style nhất quán. Mỗi công ty hay team đều có code style cho mỗi ngôn ngữ. Miễn bạn chọn một style nhất quán và scalable

2. Tên biến, lớp, hàm rõ ràng và ngắn gọn

3. Dùng các quy ước phổ thông trong toán, lý, hoá hay các domain (lĩnh vực) liên quan khi viết tên biến, lớp, hàm

4. Với thuật toán hay hàm phức tạp thì nên có comment trong code giải thích và minh hoạ bằng biểu đồ hoặc Markdown kèm theo

5. Nên chia lớp, hàm theo nguyên tắc S-O-LI-D (đặc biệt hữu ích với OOP):
  5.1. The Single Responsibility Principle: https://code.tutsplus.com/tutorials/solid-part-1-the-single-responsibility-principle--net-36074
  5.2. The Open/Closed Principle: https://code.tutsplus.com/tutorials/solid-part-2-the-openclosed-principle--net-36600
  5.3. Liskov Substitution & Interface Segregation Principles: https://code.tutsplus.com/tutorials/solid-part-3-liskov-substitution-interface-segregation-principles--net-36710
  5.4. The Dependency Inversion Principle: https://code.tutsplus.com/tutorials/solid-part-4-the-dependency-inversion-principle--net-36872

6. Sử dụng các Design Patterns. Khi đã nắm vững SOLID thì các bạn có thể chuyển sang để làm các project tầm cỡ. Không thể nào trở thành senior nếu bạn không nắm được Design Patterns. Các bạn nên đọc Design Patterns của Gang of Four: https://www.amazon.co.uk/Design-patterns-elements-reusable-object-oriented/dp/0201633612

Quan niệm của tôi là Code is **Compassion & Code is Communication**. Theo tôi chúng ta viết code vì chúng ta muốn giúp đỡ, muốn giải quyết vấn đề của bản thân, gia đình, khách hàng & thế giới, vì vậy: **Code is Compassion**. Chúng ta viết code vì chúng ta giao tiếp với các kỹ sư phần mềm nhiều thế hệ khác nhau và có nhiều trải nghiệm khác nhau. Khi đọc code, chúng ta có thể truyền tải và hiểu những ý tưởng để học hỏi lẫn nhau, vì vậy: **Code is Communication**.

Chắc hẳn các bạn đã học code ở Việt Nam, ở Singapore, ở Vương quốc Anh, ở Mỹ, Coursera, edX và vô số các trang online khác. Nhưng có một điểm thiếu sót chung của các trường và các hệ thống đó là: **Không có code review**. Khi bạn học tiếng Việt, tiếng Anh thì đều có thầy cô giáo chấm bài và sửa lỗi cho bạn. Đến khi bạn học và tập tành làm kỹ sư thì không có ai sửa lỗi cho bạn từ khi còn thơ. Ở Code2Pro và trong chương trình đặc biệt Dev Việt Ra Khơi chúng tôi có phương châm: Code is Compassion & Code is Communication. Code2Pro và Dev Việt Ra Khơi là nơi duy nhất các bạn có thể học code và được làm code review để rèn luyện kỹ năng hoàn thiện để trở thành kỹ sư phần mềm có tầm quốc tế.

Để được cập nhật thông tin, mời các bạn theo dõi page: https://www.facebook.com/Code2Pro/

Bạn nào muốn code thử vào biết mình viết có chuyên nghiệp không, có thể tham gia: https://www.facebook.com/groups/DevVietRaKhoi/

Những bạn nào nung nấu vươn ra khỏi Việt Nam có thể đăng ký xem video & slides của sự kiện Dev Việt Ra Khơi: http://www.code2.pro/p/dev-viet-ra-khoi-uk-singapore

Các bạn chia sẻ đến với nhiều bạn sinh viên và các kỹ sư phần mềm Việt Nam để mọi người cùng học hỏi và vươn ra thế giới nhé!
