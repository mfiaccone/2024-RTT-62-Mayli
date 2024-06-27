function changeText() {
    const p = document.querySelector('p');
    p.textContent = "Changed because of an event handler property.";
    
    const button = document.querySelector('button');
    button.textContent = "Vote placed!";

  }

  
  function validateForm() {
    var emailInput = document.getElementById('inputEmail3');
    var emailError = document.getElementById('emailError');
    
    // Regular expression for basic email validation
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(emailInput.value)) {
        emailError.style.display = 'block';
        emailInput.classList.add('is-invalid'); // Optional: Bootstrap 4 styling for invalid input
        return false; // Prevent form submission
    } else {
        emailError.style.display = 'none';
        emailInput.classList.remove('is-invalid'); // Optional: Remove the styling if valid
        return true; // Allow form submission
    }
}