export type NoteDto = {
  userId: number;
  noteId?: number;
  title: string;
  content: string;
  creationDate?: string;
  lastModified?: string;
  image?: string;
};
