import axios from "axios"

const POST_API_BASE_URL = "http://localhost:8081/api/Relation/";
const POSTID_API_BASE_URL = "http://localhost:8080/api/Post/6";
const POSTSIGNALED_API_BASE_URL = "http://localhost:8080/api/PostSignaled/true";

class PostService {
    getPost(id) {
        return axios.get(POST_API_BASE_URL+ id);
    }

    getPostbyId() {
        // console.log("lol");
        return axios.get(POSTID_API_BASE_URL);
        // return axios.get(POSTID_API_BASE_URL);
    }

    getPostSignaled(){
        return axios.get(POSTSIGNALED_API_BASE_URL);
    }

}

export default new PostService()