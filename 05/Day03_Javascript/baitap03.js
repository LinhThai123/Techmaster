/* Tạo 1 thẻ p có id=“text”, có nội dung bất kỳ (có thể tạo bằng HTML hay Javascript - tùy chọn). Yêu cầu
Đặt màu văn bản thành #777
Đặt kích thước phông chữ thành 2rem
Đặt nội dung HTML thành Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript. */
let changeText = document.getElementById("text"); 

changeText.style.color = "#777";
changeText.style.fontSize = " 2rem"; 
changeText.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript."
changeText.innerText = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript." 

//Sử dụng vòng lặp để đặt màu chữ cho tất cả thẻ li thành màu blue (tạo thẻ ul-li bằng html)
let paras = document.querySelectorAll("li");
console.log(paras);
paras.forEach(element => element.style.color = 'blue'); 

//Cho mã HTML có nội dung như sau (tạo thẻ ul-li bằng html):
const list = document.getElementById("list"); 
const li8   = document.createElement("li");
li8.innerHTML = "item 8"; 
const li_1 = document.querySelector("#list li:nth-child(8)"); 
list.insertBefore(li8, li_1); 

const li9 = document.createElement("li");
li9.innerHTML = "item 9"; 
list.appendChild(li9);

const li10 = document.createElement("li");
li10.innerHTML = "item 10"; 
list.appendChild(li10);

//Sửa nội dung cho thẻ <li> 1 thành màu đỏ (color) 
const changeLi1 = document.querySelector("#list li:nth-child(1)"); 
console.log(changeLi1);
changeLi1.style.color = "red"; 

//Sửa background cho thẻ <li> 3 thành màu xanh (background-color)
const changeLi3 = document.querySelector("#list li:nth-child(3)"); 
changeLi3.style.backgroundColor = "green"; 

//Remove thẻ <li> 4 
const changeLi4 = document.querySelector("#list li:nth-child(4)");
console.log(changeLi4);
changeLi4.remove(); 

//Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ 
const li_new = document.createElement("li");
li_new.innerHTML = "Thẻ thêm mới để thay thế có item 4 "; 
const li_4 = document.querySelector("#list li:nth-child(4)"); 
list.insertBefore(li_new, li_4);