function find(mark) {
  if (mark >= 85) {
    console.log("A");
  } else if (mark >= 70 && mark < 85) {
    console.log("B");
  } else if (mark >= 40 && mark < 70) {
    console.log("C");
  } else {
    console.log("D");
  }
}
/*Viết function nhập vào biến mark có giá trị từ 0 -> 100. Kiểm tra giá trị của biến mark và in ra nội dụng sau
”A” nếu mark >= 85
”B” nếu 70 <= mark < 85 (70 <= mark && mark < 85)
”C” nếu 40 <= mark < 70 (40 <= mark && mark <70)
Các trường hợp còn lại in ra “D” */
find(80);

function sort(a, b) {
  if (a > b) {
    return a;
  } else {
    return b;
  }
}
/*Viết function truyền vào 2 số a, b. In ra màn hình số có giá trị lớn hơn */
console.log(sort(3, 4));

function check(num) {
  if (num > 0) {
    console.log("Số Dương");
  } else {
    console.log("Số Ấm ");
  }
}
/*Viết function nhập vào 1 số. Kiểm tra số đó là số âm, số dương hay là số 0. */
check(1);

function checkEven(number) {
  if (number % 2 == 0) {
    console.log("chan");
  } else {
    console.log("le");
  }
}
/*Viết function nhập vào 1 số. Kiểm tra số đó là số chẵn hay số lẻ. */
checkEven(4);

function chiaHet(number) {
  let a, b;
  if (number % 3 == 0 && number % 5 == 0) {
    return true;
  } else {
    return false;
  }
}
/*Viết function nhập vào 1 số. Kiểm tra số đó có đồng thời chia hết cho 3 và 5 không.*/
console.log(chiaHet(9));

function checkNumber(a, b, c) {
  let d = a + b;
  if (c === d) {
    return true;
  } else {
    return false;
  }
}
/* Viết function nhập vào 3 số a, b, c. Kiểm tra xem c có bằng a + b không?*/
console.log(checkNumber(3, 4, 6));

/*Tạo biến day có giá trị từ 0 -> 6, là các ngày trong tuần Trong đó: (0 - chủ nhật, 1 - thứ 2, …, 6 - Thứ 7)
Sử dụng switch-case để in ra ngày tương ứng với giá trị của biến day
Ví dụ: day = 6 --> “Hôm nay là thứ 7” */
function checkDay(day) {
  switch (day) {
    case 0:
      return "Chủ Nhật ";
    case 1:
      return "Thứ 2";
    case 2:
      return "Thứ 3";
    case 3:
      return "Thứ 4";
    case 4:
      return "Thứ 5";
    case 5:
      return "Thứ 6";
    case 6:
      return "Thứ 7";
    default:
      return "Nhập đúng thứ ";
  }
}
console.log(checkDay(3));
/*Tạo biến month có giá trị từ 1 -> 12, là các tháng trong năm
Sử dụng switch-case để in ra mùa tương ứng với giá trị của biến month
1, 2, 3 : Mùa xuân
4, 5, 6 : Mùa hạ
7, 8, 9 : Mùa thu
10, 11, 12 : Mùa đông */

function springMonth(month) {
  switch (month) {
    case 1:
    case 2:
    case 3:
      return "Mùa Xuân";
    case 4:
    case 5:
    case 6:
      return "Mùa Hè";
    case 7:
    case 8:
    case 9:
      return "Mùa Thu";
    case 10:
    case 11:
    case 12:
      return "Mùa Đông";
  }
}
console.log(springMonth(10)); 
/*Viết function truyền vào 1 chuỗi bất kỳ, hãy sao chép chuỗi đó lên 10 lần.
Ví dụ : repeatString(“a”) => Kết quả trả về là “aaaaaaaaaa”*/
function chuoi() {
    let chuoi = ""; 
    for (let i = 1; i <= 10; i++) {
        chuoi += "a"; 
    }
    return chuoi;
}
console.log(chuoi());  
/*iết function truyền vào 1 chuỗi bất kỳ, hãy viết hàm có tác dụng sao chép đó chuỗi lên 10 lần, ngăn cách nhau bởi dấu gạch ngang.
Ví dụ: repeatString(“a”) => Kết quả trả về là “a-a-a-a-a-a-a-a-a-a” */
function chuoi1() {
    let chuoi = ""; 
    for (let i = 1; i <= 10; i++) {
        chuoi += `${"-a"}`; 
    }
    return chuoi.slice(1); 
}
console.log(chuoi1());
/* Viết function truyền vào 1 chuỗi bất kỳ và 1 số nguyên dương n > 1, hãy viết hàm có tác dụng sao chép đó chuỗi lên n lần, ngăn cách nhau bởi dấu gạch ngang.*/
function chuoi2(n) {
    let chuoi = "-a"; 
     let result = ""; 
    for (let i = 0; i < n; i++) {
        result += chuoi
    }
    return result.slice(1);
}
console.log(chuoi2(2)); 
/*Tính tổng các số chia hết cho 5 từ 0 -> 100*/
function sum() {
  let tong = 0; 
  for (let i = 0; i <= 100; i++) {
    if (i % 5 == 0) {
      tong += i; 
    }
  }
  return tong; 
}
console.log(sum()); 
// Bài tập về nhà Javascript 
/* Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó
Ví dụ: calculateFactorial(5) = 5 * 4 * 3 * 2 * 1 = 120*/
function giaiThua(number) {
  if (number == 0 ) {
    return  1; 
  }
  let t = number * giaiThua(number - 1);
  return t; 
}
console.log(giaiThua(5)); 
/*Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó
Ví dụ: reverseString(‘hello’) => olleh */
function reverseString(str) {
  let strs = str.split(""); 
  let currentStr = strs.reverse(); 
  let newStr = currentStr.join("");
  return newStr; 
}
console.log(reverseString("hello")); 
/*Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào
Ví dụ: translate(‘VN’) => “Xin chào”
translate(‘EN’) => “Hello”
Gợi ý : Sử dụng switch - case . Học viên tự nghĩ ra 1 vài mã quốc gia và câu chào tương ứng với quốc gia đó */
function National(translate) {
  switch (translate) {
    case "VN":
      return "Xin Chào";
    case "EN":
      return "Hello";
    case "HG":
      return "Szia";
    case "Ita":
      return "Ciao"; 
    default: return "Nhập tên các quốc gia "; 
  }
}
console.log(National("EN")); 
/*Cho function truyền vào 1 chuỗi dài hơn 15 ký tự. Viết 1 function cắt chuỗi, lấy ra 10 ký tự đầu tiên và thêm vào dấu “…” ở cuối chuỗi.
Ví dụ : subString(“xinchaocacbandenvoiTechmaster”) => “xinchaocac…” */
function subString(str) {
  let str1 =  str.slice(0, 10); 
  let str2 = "..."; 
  return str1.concat(str2); 
}
console.log(subString("xinchaocacbandenvoiTechmaster"));