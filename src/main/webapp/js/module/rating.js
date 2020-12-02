export default function Rating(ratingDiv, rankSpan) {
    this.ratingDiv = ratingDiv;
    this.rankSpan = rankSpan;

    this.registerEvents();
}

Rating.prototype = {
    registerEvents() {
        this.ratingDiv.addEventListener("click", (event) => {
            if (event.target.tagName !== "INPUT") {
                return;
            }

            const starCount = parseInt(event.target.getAttribute("value"));
            this.changeStar(starCount);
            this.changeScore(starCount);
        })
    },

    changeStar(starCount) {
        this.ratingDiv.querySelectorAll(".rating_rdo").forEach((ratingStar, starIndex) => {
            ratingStar.classList.remove("checked");

            if (starIndex < starCount) {
                ratingStar.classList.add("checked");
            }
        })
    },

    changeScore(starCount) {
        if (starCount <= 0) {
            this.rankSpan.classList.add("gray_star");
        } else {
            this.rankSpan.classList.remove("gray_star");
        }
        this.rankSpan.innerText = starCount;
    }
}