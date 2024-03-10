import { Category } from "./Category"

export type Game = {
    id: number,
    name: string,
    imgUrl: string,
    platform: string,
    review:string,
    grade: number,
    status: string,
    categories: Category[]
}
