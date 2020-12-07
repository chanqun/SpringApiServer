export default function ReviewText(reviewWriteAnchor, reviewTextArea, textCountSpan) {
    this.reviewWriteAnchor = reviewWriteAnchor;
    this.reviewTextArea = reviewTextArea;
    this.textCountSpan = textCountSpan;

    this.registerEvent();
}

ReviewText.prototype = {
    registerEvent() {
        this.reviewWriteAnchor.addEventListener("click", this.showReviewTextArea.bind(this));

        this.reviewTextArea.addEventListener("blur", this.hideReviewTextArea.bind(this), event);

        this.reviewTextArea.addEventListener("input", this.changeReviewTextCount.bind(this), event);
    },

    validateTextCount() {
        const textLength = this.reviewTextArea.textLength;
        let minTextLength = 5;
        let maxTextLength = 400;

        return (textLength >= minTextLength && textLength <= maxTextLength);
    },

    changeReviewTextCount(event) {
        this.textCountSpan.innerText = event.target.textLength;
    },

    showReviewTextArea() {
        this.reviewWriteAnchor.style.display = "none";
        this.reviewTextArea.focus();
    },

    hideReviewTextArea(event) {
        if (event.target.textLength === 0) {
            this.reviewWriteAnchor.style.display = "block";
        }
    }
}