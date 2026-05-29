document.addEventListener("DOMContentLoaded", function () {

    let count = 0;
    const countDisplay = document.getElementById("count")
    const msgShow = document.getElementById("msgbtn")
    const ibtn = document.getElementById("ibtn")
    const dbtn = document.getElementById("dbtn")
    const savebtn = document.getElementById("savebtn")
    const resetbtn = document.getElementById("resetbtn")
    const loadbtn = document.getElementById("loadbtn")


    ibtn.addEventListener("click", increaseCount);
    dbtn.addEventListener("click", decreaseCount);
    resetbtn.addEventListener("click", resetCount);
    savebtn.addEventListener("click", saveCount);
    loadbtn.addEventListener("click", loadCount);
   

        function message(Text){
            msgShow.innerHTML = Text;
            setTimeout(function() {
                msgShow.innerHTML ="";
            },3000);
        }

        function updateCount(){
            document.getElementById("count").innerHTML = count;
        }

        function increaseCount(){
            count++;
            updateCount();
        }

        function decreaseCount(){
            count--;
            updateCount();
        }

        function resetCount(){
            count = 0;  
            updateCount();
        }

        function saveCount(){
            localStorage.setItem("count", count);
            message("Saved!!");
        }

        function loadCount(){
            let saved = localStorage.getItem("count");
            if(saved !== null){
                count = Number(saved);
                message("Loaded!!");
            }
            updateCount();
        }
});
