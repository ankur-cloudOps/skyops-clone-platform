export interface Drone {
  id: number;
  manufacturer: string;
  model: string;
  category: string;
  registrationNumber: string;
  serialNumber: string;
  status: string;
  weight: number;
  createdAt: string;
  updatedAt: string | null;
}