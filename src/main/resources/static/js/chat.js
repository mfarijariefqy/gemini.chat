document.addEventListener('DOMContentLoaded', () => {
    const chatBox = document.getElementById('chat-box');
    const chatForm = document.getElementById('chat-form');
    const messageInput = document.getElementById('message-input');

    chatForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const userMessage = messageInput.value.trim();
        if (!userMessage) return;

        // Tampilkan pesan pengguna di chat box
        appendMessage(userMessage, 'user');
        messageInput.value = '';

        // Tampilkan indikator "mengetik..."
        const typingIndicator = showTypingIndicator();

        try {
            // Kirim pesan ke backend
            const response = await fetch('/api/chat', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ message: userMessage }),
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const data = await response.json();
            const aiReply = data.reply;

            // Hapus indikator "mengetik..."
            hideTypingIndicator(typingIndicator);
            // Tampilkan balasan AI
            appendMessage(aiReply, 'ai');

        } catch (error) {
            console.error('Error:', error);
            hideTypingIndicator(typingIndicator);
            appendMessage('Maaf, terjadi kesalahan. Coba lagi nanti.', 'ai');
        }
    });

    function appendMessage(message, sender) {
        const messageWrapper = document.createElement('div');
        messageWrapper.classList.add('chat-message', `${sender}-message`);

        const messageBubble = document.createElement('div');
        messageBubble.classList.add('message-bubble');
        // Menggunakan innerText untuk keamanan, mencegah XSS
        messageBubble.innerText = message;

        messageWrapper.appendChild(messageBubble);
        chatBox.appendChild(messageWrapper);
        chatBox.scrollTop = chatBox.scrollHeight; // Auto-scroll ke bawah
    }

    function showTypingIndicator() {
        const indicatorWrapper = document.createElement('div');
        indicatorWrapper.classList.add('chat-message', 'ai-message', 'typing-indicator');

        const bubble = document.createElement('div');
        bubble.classList.add('message-bubble');
        bubble.innerText = 'AI is typing...';

        indicatorWrapper.appendChild(bubble);
        chatBox.appendChild(indicatorWrapper);
        chatBox.scrollTop = chatBox.scrollHeight;
        return indicatorWrapper;
    }

    function hideTypingIndicator(indicator) {
        if (indicator) {
            chatBox.removeChild(indicator);
        }
    }
});