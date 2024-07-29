export type RegisterUser = {
  name: string;
  username: string;
  email: string;
  password: string;
  confirmPassword: string;
};
export type RegisterUserDto = {
  id?: number | null;
  notes?: [];
  username: string;
  name: string;
  email: string;
  password: string;
};
