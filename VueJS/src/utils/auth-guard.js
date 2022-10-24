import router from '@/router'

export function authGuard(to){
    let token = localStorage.getItem('jwtToken')
    
    if(token ){
        return true
    }
    router.push('/')
}