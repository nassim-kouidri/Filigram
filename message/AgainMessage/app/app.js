// Message Component
Vue.component('message', {
    props: ['messageData'],
    template: ` <div class="media-content">
                    <div class="content">
                        <p>
                            <strong>{{messageData.user}}</strong> <small>{{messageData.date}}</small>
                            <br>
                            {{messageData.text}}
                        </p>
                    </div>
                </div>`
});

// Input message Component
Vue.component('input-message', {
    data: function() {
        return {
            message: ''
        }
    },
    template: ` <div class="controls" class="field has-addons">
                    <div class="control is-expanded">
                        <input v-model="message" v-on:keydown.enter="send" class="input is-primary" placeholder="Write message">
                    </div>
                    <div class="control">
                        <!-- we disable the button when message has not completed -->
                        <button v-on:click="send" :disabled="!message" class="button is-primary">Send</button>
                    </div>
                </div>`,
    methods: {
        send: function() {
            // If there is a message, input-message emits a send-message event with the message to the parent component (app)
            if (this.message.length > 0) {
                this.$emit('send-message', this.message);
                this.message = '';
            }
        }
    }
});

// Input user name Component
Vue.component('input-name', {
    props: ['isLogged'],
    data: function() {
        return {
            userName: ''
        }
    },
    template: `<div id="nameInput" v-show="!isLogged">
                    <div class="field is-grouped">
                        <div class="control">
                            <input v-model="userName" v-on:keydown.enter="sendUserName" class="input is-primary" placeholder="Your name">
                        </div>
                        <div class="control">
                            <button v-on:click="sendUserName" :disabled="!userName" class="button is-primary">Enter</button>
                        </div>
                    </div>
                </div>`,
    methods: {
        sendUserName: function() {
            // If there is a userName, input-name emits a set-name event with the userName to the parent component (app)
            if (this.userName.length > 0) {
                this.$emit('set-name', this.userName);
            }
        }
    }
});

// Users component
// iterating over users array and displaying the data
Vue.component('users', {
    props: ['users'],
    template: ` <div>
                    <h4 class="title is-4">Current users ({{users.length}})</h4>
                    <ul>
                        <li v-for="user in users">
                            <div class="media-content">
                                <div class="content">
                                    <p>
                                        <strong>{{user.name}}</strong>
                                    </p>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>`
});

// Vue instance
var app = new Vue({
    el: '#app',
    data: {
        messages: [],
        users: [],
        userName: '',
        isLogged: false
    },

    methods: {
        sendMessage: function(message) {
            if (message) {
                socket.emit('send-msg', { message: message, user: this.userName });
            }
        },
        setName: function(userName) {
            this.userName = userName;
            this.isLogged = true;
            socket.emit('add-user', this.userName);
        },
        // This method is used to scroll the chatbox when a new message is printed
        scrollToEnd: function() {
            var container = this.$el.querySelector("#messages");
            container.scrollTop = container.scrollHeight;
        },
    },

    updated() {
        this.scrollToEnd();
    }

});