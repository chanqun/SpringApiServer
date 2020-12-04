export default function ReviewText(reviewWriteAnchor, reviewTextArea, textCountSpan) {
    this.reviewWriteAnchor = reviewWriteAnchor;
    this.reviewTextArea = reviewTextArea;
    this.textCountSpan = textCountSpan;

    this.registerEvent();
}

ReviewText.prototype = {
    registerEvent() {
        this.reviewWriteAnchor.addEventListener("click", () => {
            this.reviewWriteAnchor.style.display = "none";
            this.reviewTextArea.focus();
        })

        this.reviewTextArea.addEventListener("blur", (event) => {
            if (event.target.textLength === 0) {
                this.reviewWriteAnchor.style.display = "block";
            }
        })

        this.reviewTextArea.addEventListener("input", (event) => {
            this.textCountSpan.innerText = event.target.textLength;
        })
    },

    validateTextCount() {
        const textLength = this.reviewTextArea.textLength;
        let minTextLength = 5;
        let maxTextLength = 400;

        return (textLength >= minTextLength && textLength <= maxTextLength);
    }
}