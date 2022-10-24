<template>
    <div>
        <div class="imagePreviewWrapper" :style="{'background-image': `url(${previewImage})` }" @click="selectImage"></div>
        <input ref="fileInput" id="myFile" type="file" @input="pickFile">

        
        
    </div>
    <!-- <h1>Hello</h1> -->

</template>
<script>

export default{

    data() {
        return{
            previewImage: null,
            filename: null,
        };
    },
    methods: {
        selectImage (){
            this.$refs.fileInput.click()
            // const image = event.target.files[0]
            
            
        },
        pickFile(){
            var filee = document.getElementById('myFile').files[0];
            var filename = filee.name;
            console.log(filename)
            // this.$emit('filename', this.filename)


            let input = this.$refs.fileInput

            let file = input.files

            if(file && file[0]){
                let reader = new FileReader
                reader.onload = e =>{
                    this.previewImage = e.target.result
                    // console.log(e.target.readAsDataURL)
                    const fs = require("fs");
                    // let base64 = ""
                    const buffer = Buffer.from(e.target.readAsDataURL, "base64");
                    fs.writeFileSync("new-path.jpg", buffer);
                }
                reader.readAsDataURL(file[0])
                
                this.$emit('input', file[0])
                
            }
            return filename

        }
    },
     props: {
    filename: String
  }

// let h = document.getElementById('myFile').files[0].name
// console.log(h)

}





</script>
<style>
.imagePreviewWrapper{
    width: 608px;
    height: 250px;
    display: block;
    cursor: pointer;
    /* margin: 0 auto 30px; */
    background-size: cover;
    background-position: center center;
}
</style>
