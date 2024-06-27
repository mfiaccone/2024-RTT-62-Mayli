function changeText() {
    const p = document.querySelector('p');
    p.textContent = "Changed because of an event handler property.";
    
    const button = document.querySelector('button');
    button.textContent = "Vote placed!";

  }