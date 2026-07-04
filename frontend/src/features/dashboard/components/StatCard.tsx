import {
  Card,
  CardContent,
  Typography
} from "@mui/material";

type Props = {
  title: string;
  value: string;
  color: string;
};

export default function StatCard({
  title,
  value,
  color
}: Props) {
  return (
    <Card elevation={2}>
      <CardContent>

        <Typography color="text.secondary">
          {title}
        </Typography>

        <Typography
          variant="h4"
          sx={{
            mt: 1,
            color,
            fontWeight: 700
          }}
        >
          {value}
        </Typography>

      </CardContent>
    </Card>
  );
}