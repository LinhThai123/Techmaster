## Câu 1 : Thuộc tính name trong annotation @Entity khác với thuộc tính name trong @Table như thế nào? Hãy giải thích rõ cần thì minh hoạ
 **Giống nhau** : Thuộc tính name trong @Entity và @Table giống nhau đều sử dụng để thay đổi tên của Entity và Table( nó không bắt buộc)
 **Khác nhau** : 
 ```java
 @Entity(name = "linh") //cái này dùng để chỉ tên của Entity được Hibernate quản lsy 
 @Table(name="Linh") // còn đây là tên của table được tạo ra trong table 
 ```

## Câu 2 : Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung lệnh nào vào file application.properties?
Cách đơn giản nhất để có thể xem các câu truy vấn xuất ra các thiết bị output như màn hình console v.v là thêm một thuộc tính vào file `application.properties`.
```java
spring.jpa.show-sql=true
```
Để câu truy vấn xuất ra màn hình có định dạng rõ ràng và dễ nhìn hơn chúng ta thêm :
```java
spring.jpa.properties.hibernate.format_sql=true
```
## Câu 3 : Khi sử dụng H2, làm thế nào để xem được cơ sở dữ liệu và viết câu truy vấn?
Vào locohost:8080/h2-console và đăng nhập để xem cơ sở dữ liệu và có thể viết query 
## Câu 4 :Khi viết mô tả một model, những thuộc tính chúng ta không muốn lưu xuống CSDL thì cần đánh dấu bằng annotation nào?
`@Formula` Trường dạng SQL formula sinh động khi truy vấn, không lưu xuống bảng. 
`@Transient` Trường tạm thời sinh động lúc gọi Getter

## Câu 5: Annotation @Column dùng để bổ sung tính chất cho cột ứng với một thuộc tính. Tham số nào trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính, tham số nào chỉ định yêu cầu duy nhất, không được trùng lặp dữ liệu, tham số nào buộc trường không được null?
* Tham số `name` trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính
* Tham số `unique` chỉ định yêu cầu duy nhất 
* Không được trùng lặp dữ liệu ``
* Tham số `nullable = false` buộc trường không được null
## Câu 6 :Có 2 sự kiện mà JPA có thể bắt được, viết logic bổ sung Ngay
### Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT)  
Annotation `@PrePersist`
### Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE) ? Vậy 2 annotation này là gì
Annotation `@PreUpdate`
## Câu 7: Tổ hợp các trường thông tin địa chỉ: country, city, county, addressline thường luôn đi cùng nhau và sử dụng lại trong các Entity khác nhau. Nhóm 2 annotation nào dùng để tái sử dụng, nhúng một Entity vào một Entity khác? 
* Nhóm 2 annotation `@Embeddable`,`@Embedded`  dùng để tái sử dụng, nhúng một Entity vào một Entity khác 
* Khi có nhiều bảng chung nhau một cấu trúc, thì đánh dấu cấu trúc dùng chung bằng `@Embeddable`
* Những bảng dùng chung cấu trúc đánh dấu bằng `@Embedded`
## Câu 8 : JpaRepository là một interface có sẵn trong thư viện JPA, nó cũng cấp các mẫu hàm thuận tiện cho thao tác dữ liệu. 
 JPA Repository kế thừa các interface :CRUD Repository , Paging And Sorting Repository

## Câu 9 : Hãy viết khai báo một interface repository thao tác với một Entity tên là Post, kiểu dữ liệu trường Identity là long, tuân thủ interface JpaRepository.
Entity Post 
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Post")
@Table (name = "post")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    
    private String name ; 
}
```
Khai báo interface PostRepository
```java 
@Repository
public interface PostRepository extends JpaRepository<Post , Long> {
}
```
## Câu 10: Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì có cần phải dùng xác định unique dùng annotation @Column(unique=true) không? 
Khi đã chọn một cột là Identity dùng @Id để đánh dấu thì không cần phải dùng annotation @Column(unique=true) vì @Id là duy nhất rồi

## Câu 11 : Khác biệt giữa @Id với @NaturalId là gì? 
`@NaturalID` tạo unique constrain lên một trường không phải PrimaryKey 
`@Id` xác định trường nào là primaryKey , đã là primaryKey thì  phải unique 

## Câu 12 : Có những cột không phải primary key (@Id) hay @NaturalId, dữ liệu có thể trùng lặp (unique không đảm bảo true), nhưng cần đánh chỉ mục (index) để tìm kiếm nhanh hơn vậy phải dùng annotation gì? Hãy viết 1 ví dụ sử dụng annotation đó với index cho 1 column và 1 ví dụ với index cho tổ hợp nhiều column. Tham khảo tại (https://www.baeldung.com/jpaindexes)
 Nhưng cần đánh chỉ mục (index) để tìm kiếm nhanh hơn vậy phải dùng annotation `@Index`

## Câu 13 : Annotation @GeneratedValue dùng để chọn cách tự sinh unique id cho primary key phải là trường kiểu int hoặc long. Nếu trường primary key có kiểu là String, chúng ta không thể dùng @GeneratedValue vậy hãy thử liệt kê các cách đảm bảo sinh ra chuỗi có tính duy nhất?
* Custom ID generator
* Sử dụng UUID 

## Câu 14 : 
## Câu 15 : Hãy nêu cách sử dụng của @NamedQuery và @Query. Cho ví dụ
Nếu bạn không sử dụng repository interface mà chỉ dùng EntityManager để thao tác dữ liệu. Query đó
sử dụng ở nhiều nơi khác nhau thì có thể dùng `@NamedQuery`.
Về mặt clean code, thì không khuyến cáo sử dụng `@NamedQuery`
Ví dụ `@NamedQuery`
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.fetchByLastNameLength",
        query = "SELECT e FROM Employee e WHERE CHAR_LENGTH(e.lastname) =:length "
)
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column(name = "firstname")
    private String firstName;
 
    @Column(name = "lastname")
    private String lastname;
```
Với annotation `@Query` ta có thể khai báo câu query cho các method trong repository.
Việc khai báo câu query với `@Query` giúp ta tối ưu câu sql, và xử lý trong những trường hợp mà các method do Spring Data không thể đáp ứng
Để sử dụng annotation `@Query`, ta sẽ khai báo nó trước các method của interface extends từ JPARepository, CrudRepository , và truyền câu hsql vào bên trong
Ví dụ `@Query`
```java
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  @Query("SELECT e FROM Customer e WHERE e.name = ?1 AND e.address = ?2")
  List<Customer> findByNameAndAddress(String name, String address);
}
```
## Câu 16 : Làm thế nào để có thể viết custom method implemetations cho Jpa Repository. Nêu ví dụ
## Câu 17 :