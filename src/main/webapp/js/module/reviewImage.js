export default function ReviewImage(reviewImageInput, thumbnailImage, deleteButton) {
    this.reviewImageInput = reviewImageInput;
    this.thumbnailImage = thumbnailImage;
    this.deleteButton = deleteButton;

    this.registerEvent();
}

ReviewImage.prototype = {
    VALID_IMAGE_TYPE: ["image/jpg", "image/png"],

    registerEvent() {
        this.reviewImageInput.addEventListener("change", this.addReviewImage.bind(this), event);

        this.deleteButton.addEventListener("click", this.deleteReviewImage.bind(this));
    },

    addReviewImage(event) {
        const reviewImage = event.target.files[0];

        if (reviewImage && !this.VALID_IMAGE_TYPE.includes(reviewImage.type)) {
            alert("확장자가 jpg, png인 사진만 업로드 가능합니다.");
            return;
        }

        this.thumbnailImage.src = window.URL.createObjectURL(reviewImage);
        this.thumbnailImage.parentElement.style.removeProperty("display");
    },

    deleteReviewImage() {
        this.reviewImageInput.value = "";
        this.thumbnailImage.src = "";
        this.thumbnailImage.parentElement.style.display = "none";
    }
}