import axios, { AxiosError, AxiosInstance, InternalAxiosRequestConfig } from "axios";

const BASE_URL = `https://api.spotify.com/v1/`; // Updated to include 'v1'

export const baseInstance: AxiosInstance = axios.create({
    baseURL: BASE_URL,
});

baseInstance.interceptors.request.use((config: InternalAxiosRequestConfig<any>) => {
    let correctPath: boolean = config.url !== "login";
    const token = localStorage.getItem("accessToken");
    if (token && correctPath) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
    },
    (error: AxiosError) => {
        return Promise.reject(error);
    }
);
