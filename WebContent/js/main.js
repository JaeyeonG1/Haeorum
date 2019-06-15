//test

// 메인 화면 슬라이드 쇼
let sliderWrapper = document.getElementById(`sliderWrapper`);
let sliderIndex = 0;
let slides = document.querySelectorAll(`#sliderWrapper ul li`);
let totalSlides = slides.length;
let sliderWidth = sliderWrapper.clientWidth;

slides.forEach(function(element){
    element.style.width = sliderWidth + `px`;
})

let slider = document.querySelector(`#sliderWrapper ul#slider`);
slider.style.width = sliderWidth * totalSlides +`px`;

let nextBtn = document.getElementById(`next`);
let prevBtn = document.getElementById(`previous`);

nextBtn.addEventListener(`click`, function(){
    plusSlides(1);
});
prevBtn.addEventListener(`click`, function(){
    plusSlides(-1);
});

sliderWrapper.addEventListener(`mouseover`, function(){
    this.classList.add(`active`);
    clearInterval(autoSlider);
});
sliderWrapper.addEventListener(`mouseleave`, function(){
    this.classList.add(`active`);
    autoSlider = setInterval(function(){
        plusSlides(1);
    }, 3000);    
})

function plusSlides(n) {
    showSlides(sliderIndex += n);
}

function currentSlides(n) {
    showSlides(sliderIndex = n);
}

function showSlides(n) {
    sliderIndex = n;
    if (sliderIndex == -1) {
        sliderIndex = totalSlides - 1;
    } else if (sliderIndex === totalSlides) {
        sliderIndex = 0;
    }

    slider.style.left = -(sliderWidth * sliderIndex) + 'px';
    pagination();
}

let autoSlider = setInterval(function () {
    plusSlides(1);
}, 3000);

slides.forEach(function () {
    let li = document.createElement('li');
    document.querySelector('#sliderPagination ul').appendChild(li);
})

function pagination() {
    let dots = document.querySelectorAll('#sliderPagination ul li');
    dots.forEach(function (element) {
        element.classList.remove('active');
    });
    dots[sliderIndex].classList.add('active');
}

pagination();