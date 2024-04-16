import { apiClient } from './ApiClient'

//User Urls
export const retriveUserByUsernameApi =(username) => apiClient.get(`/api/users/${username}`)


//Owner Urls
// export const retriveUserByUsernameApi =(username) => apiClient.get(`/api/users/${username}`)

//Playground Urls
export const retriveAllPlaygroundsApi =() => apiClient.get(`/api/playgrounds`)
export const retrivePlaygroundByIdApi =(playgroundId) => apiClient.get(`/api/playgrounds/${playgroundId}`)
export const retrivePlaygroundsByOwnerUsernameApi =(username) => apiClient.get(`/api/playgrounds/username/${username}`)
export const retrivePlaygroundsByLocationApi =(location) => apiClient.get(`/api/playgrounds/bylocation?location=`+ location)
export const retrivePlaygroundsBySearchApi =(keyword) => apiClient.get(`/api/playgrounds/search?keyword=`+keyword)

//Booking Urls
export const retriveAllBookingsApi =() => apiClient.get(`/api/bookings`)
export const retriveAllBookingsByUsernameApi =(username) => apiClient.get(`/api/bookings/user/${username}`)
export const retriveBookingByUsernameAndPlaygroundIdApi =(username,playgroundId) => apiClient.get(`/api/bookings/user/${username}/playground/${playgroundId}`)
export const retriveAllBookingsByOwnerUsernameApi =(username) => apiClient.get(`/api/bookings/owner/${username}`)
export const retriveBookingByOwnerUsernameAndPlaygroundIdApi =(username,playgroundId) => apiClient.get(`/api/bookings/owner/${username}/playground/${playgroundId}`)
