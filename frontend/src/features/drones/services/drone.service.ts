import axios from "axios";
import type { Drone } from "../types/drone";

const API = "http://localhost:8080/api/v1/drones";

export const getDrones = async (): Promise<Drone[]> => {
  const { data } = await axios.get(API);
  return data;
};

export const createDrone = async (drone: Omit<Drone, "id" | "createdAt" | "updatedAt">) => {
  const { data } = await axios.post(API, drone);
  return data;
};

export const updateDrone = async (id: number, drone: Partial<Drone>) => {
  const { data } = await axios.put(`${API}/${id}`, drone);
  return data;
};

export const deleteDrone = async (id: number) => {
  await axios.delete(`${API}/${id}`);
};