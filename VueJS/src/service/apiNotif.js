import Axxios from "../configNotif"

let setFollowNotif= (credential) =>{
    return Axxios.post('/subscribers/Jesus/events/08DMMelOGV', credential)
}

let setLikeNotif = (credential) =>{
    return Axxios.post('/subscribers/Jesus/events/QZw8FQx8fy', credential)
}

export const ApiNotif = {
    setLikeNotif,
    setFollowNotif,
}