import { METHODS } from "http";

export default {

    name: "codeJs",
    components: {

    },
    data() {
        return {
            // console.log("JE SUIS LA");
        };
    },
    methods: {
         previewFile() {
    const preview = document.querySelector('img');
    const file = document.querySelector('input[type=file]').files[0];
    const reader = new FileReader();
  
    reader.addEventListener("load", function () {
      // on convertit l'image en une chaîne de caractères base64
      preview.src = reader.result;
    }, false);
  
    if (file) {
      reader.readAsDataURL(file);
    }
  }
    }

}
var reader = new FileReader();
reader.readAsDataURL(blob); 
reader.onloadend = function() {
   base64data = reader.result;     
}



