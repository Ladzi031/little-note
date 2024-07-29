import { NoteDto } from './notes';

export type User = {
  username: string;
  password: string;
};
export type UserProfileDto = {
  id: number;
  username: string;
  name: string;
  email: string;
  password: string;
  notes: NoteDto[];
};
