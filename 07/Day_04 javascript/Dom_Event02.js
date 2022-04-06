let colors = [
      '#3498db',
      '#9b59b6',
      '#e74c3c',
      '#2c3e50',
      '#d35400',
]
const box = document.querySelector(".boxes"); 
const points = document.querySelector(".points"); 
const btn = document.getElementById("btn"); 
let count = 0; 
function createBox() {
      const box1 = document.createElement('div'); 
      const box2 = document.createElement('div'); 
      const box3 = document.createElement('div'); 
      const box4 = document.createElement('div'); 
      const box5 = document.createElement('div'); 

      box.appendChild(box1); 
      box.appendChild(box2); 
      box.appendChild(box3); 
      box.appendChild(box4); 
      box.appendChild(box5);  

      box1.classList.add('box');
      box2.classList.add('box');
      box3.classList.add('box');
      box4.classList.add('box');
      box5.classList.add('box');

      box1.style.backgroundColor = '#3498db'; 
      box2.style.backgroundColor = '#9b59b6'; 
      box3.style.backgroundColor = '#e74c3c'; 
      box4.style.backgroundColor =  '#2c3e50'; 
      box5.style.backgroundColor = '#d35400'; 

      let list = document.querySelectorAll(".box") 
      points.innerText =  document.querySelectorAll(".box").length;
      for (let i = 0; i < list.length; i++) {
            list[i].onclick = function () {
                  list[i].remove(); 
                   points.innerHTML = document.querySelectorAll(".box") .length;  
          }
      }
}
createBox(); 
btn.addEventListener("click", function () {
      createBox();
    });
