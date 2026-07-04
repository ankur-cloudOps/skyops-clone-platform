import api from '../../../api/axios';
import type { DashboardResponse } from '../types/dashboard';

export const getDashboard = async (): Promise<DashboardResponse> => {
  const { data } = await api.get('/dashboard');
  return data;
};