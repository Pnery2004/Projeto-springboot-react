import axios, { type AxiosPromise } from "axios"
import type { FoodData } from "../interface/foodData";
import { useQueries, useQuery } from "@tanstack/react-query";
const API_URL='http://localhost:8080';
const fettchData=async():AxiosPromise<FoodData[]> =>{ 
    const response=axios.get(API_URL + '/food');
    return response;
}
export function useFoodData() {
const query=useQuery({
     queryFn: fettchData,
     queryKey: ['food-data'],
     retry: 2
})
return{
    ...query,
    data: query.data?.data
}
}