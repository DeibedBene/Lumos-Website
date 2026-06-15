// Lumos Main JavaScript

document.addEventListener('DOMContentLoaded', () => {
    const body = document.body;
    
    // Theme Management
    const savedTheme = localStorage.getItem('lumos-theme') || 'system';
    applyTheme(savedTheme);

    function applyTheme(theme) {
        if (theme === 'system') {
            const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
            body.setAttribute('data-theme', prefersDark ? 'dark' : 'light');
        } else {
            body.setAttribute('data-theme', theme);
        }
    }

    // Listen for system theme changes
    window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', e => {
        if (localStorage.getItem('lumos-theme') === 'system') {
            applyTheme('system');
        }
    });
});

// Liquid Glass Parallax Effect (Simple)
document.addEventListener('mousemove', (e) => {
    const cards = document.querySelectorAll('.liquid-glass');
    const x = e.clientX / window.innerWidth;
    const y = e.clientY / window.innerHeight;

    cards.forEach(card => {
        const speed = 20;
        const xOffset = (x - 0.5) * speed;
        const yOffset = (y - 0.5) * speed;
        // card.style.transform = `translateY(-5px) perspective(1000px) rotateX(${-yOffset}deg) rotateY(${xOffset}deg)`;
    });
});
