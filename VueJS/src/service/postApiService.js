import Axios from "../configApiPost"

let deletePost = (idPost) =>{
    return Axios.delete('/deletePost/'+idPost)
}



export const PostApiService = {
    deletePost,
}