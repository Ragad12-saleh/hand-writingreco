// الوصول إلى الكاميرا وتشغيل الفيديو
const video = document.getElementById('video');
const captureButton = document.getElementById('captureButton');
const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
const recognizedTextElement = document.getElementById('recognizedText');

// إعدادات الكاميرا
navigator.mediaDevices.getUserMedia({ video: true })
    .then(stream => {
        video.srcObject = stream;
    })
    .catch(error => {
        console.error("فشل الوصول إلى الكاميرا: ", error);
    });

// عند النقر على زر التقاط الصورة
captureButton.addEventListener('click', () => {
    // رسم الإطار من الفيديو على الـ Canvas
    ctx.drawImage(video, 0, 0, canvas.width, canvas.height);

    // إرسال الصورة للتحليل (هنا يمكنك دمج التعرف على الكتابة اليدوية)
    recognizeTextFromImage(canvas);
});

// دالة لمحاكاة التعرف على النص
function recognizeTextFromImage(canvas) {
    // يمكنك استبدال هذا الكود بمكتبة Tesseract أو أي نموذج تعلم آلي آخر
    const imageData = canvas.toDataURL();
    recognizedTextElement.textContent = "جارٍ تحليل النص...";

    // في حال كنت تستخدم Tesseract أو نموذج آخر:
    /*
    Tesseract.recognize(imageData, 'eng', {
        logger: info => console.log(info)
    }).then(({ data: { text } }) => {
        recognizedTextElement.textContent = text;
    });
    */

    // محاكاة: سيظهر نص ثابت
    setTimeout(() => {
        recognizedTextElement.textContent = "هذه كتابة يدوية تم التعرف عليها!";
    }, 2000);
}