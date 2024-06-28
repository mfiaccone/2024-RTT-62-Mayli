
let totalTreatsDonated = 0;   

    // Function to handle treat donation
    function donateTreat() {
        let confirmation = confirm("Are you sure you want to donate a treat?");

        if (confirmation) {
            totalTreatsDonated++;
            updateTotalTreatsDisplay();
        }
    }

    // Function to update total treats display
    function updateTotalTreatsDisplay() {
        document.getElementById('totalTreats').textContent = totalTreatsDonated;
    }

    function initializePage() {
        document.getElementById('donateTreatBtn').addEventListener('click', donateTreat);
    }
    
    document.addEventListener('DOMContentLoaded', initializePage);


// table functions

function calculateDueDates(petName) {

    if (petName === 'kandy') {
        lastReceivedDates = [
            '11/5/23', 
            '11/5/23',
            '11/5/23'
        ];
    } else if (petName === 'colby') {
        lastReceivedDates = [
            '8/8/23', 
            '9/15/23',
            '8/1/23'
        ];
    } else if (petName === 'claude') {
        lastReceivedDates = [
            '10/12/23', 
            '10/8/23',
            '8/1/23'
        ];
    } else {
        
        return;
    }

    for (let i = 1; i <= 3; i++) { 
        let lastReceived = new Date(lastReceivedDates[i - 1]); 
        
        let dueDate = new Date(lastReceived);
        dueDate.setFullYear(dueDate.getFullYear() + 1); 
        

        let dueOnCell = document.getElementById(`dueOn${i}`);
        dueOnCell.textContent = formatDate(dueDate); 

        let lastReceivedCell = document.getElementById(`lastReceived${i}`);
        lastReceivedCell.textContent = formatDate(lastReceived);   
    }
}

calculateDueDates('kandy');
calculateDueDates('colby');
calculateDueDates('claude');


function formatDate(date) {
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let year = date.getFullYear();
    return `${month}/${day}/${year}`;
}

function handleDOMContentLoaded() {
    calculateDueDates();
}

document.addEventListener('DOMContentLoaded', handleDOMContentLoaded);



// regex validation
function onSubmit() {
    let email = document.getElementById("inputEmail3").value;
    console.log(email);

    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    console.log(re.test(email));
    if (re.test(email)) {
        console.log("The email is valid.");
    } else {
        console.log("The email is not valid.");
    }
  
    return false;
}