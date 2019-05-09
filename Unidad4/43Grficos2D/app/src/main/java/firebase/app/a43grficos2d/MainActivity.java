package firebase.app.a43grficos2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Relog(this));
    }

    public class Relog extends View {
        private  final long TIEMPO_REFRESCO = 20; // 20 o 1000 velocidad de refresco
        private Paint ColorFondoPintura;
        private Paint ManesillaPintura;

        public Relog(Context context) {
            super(context);
            init(context, null);
        }

        public Relog(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context, attrs);
        }

        public Relog(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context, attrs);
        }

        private void init(Context context, AttributeSet attrs) {
            ColorFondoPintura = new Paint();
            ColorFondoPintura.setColor(Color.	rgb(200, 10, 30));
            ColorFondoPintura.setAntiAlias(true);
            ManesillaPintura = new Paint();
            ManesillaPintura.setColor(Color.WHITE);
            ManesillaPintura.setAntiAlias(true);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { //codigo por si se cambia de tamaño
            int largo = MeasureSpec.getSize(widthMeasureSpec);
            int alto = MeasureSpec.getSize(heightMeasureSpec);
            int measuredSize = Math.min(largo, alto);
            setMeasuredDimension(measuredSize, measuredSize);
        }
        private Runnable invalidator = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        @Override
        protected void onDraw(Canvas canvas) {
            dibujarFondo(canvas);
            dibjarManecillaHora(canvas);
            dibjarManecillaMinutos(canvas);
            dibjarManecillaSegundos(canvas);
            dibujarUna(canvas);
            postDelayed(invalidator, TIEMPO_REFRESCO);
        }

        private void dibjarManecillaHora(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.2f;
            float espesor = getWidth() * 0.01f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloHora();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }

        private void dibujarFondo(Canvas canvas) {
            float circuloFondo = getHeight() / 2f;
            canvas.drawCircle(circuloFondo, circuloFondo, circuloFondo, ColorFondoPintura);
        }
        private void dibjarManecillaMinutos(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.3f;
            float espesor = getWidth() * 0.01f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloMinutos();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }

        private void dibjarManecillaSegundos(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.4f;
            float espesor = getWidth() * 0.005f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloSegundos();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }
        private float getX(float vistaRadio, float manoRadio, double angulo) {
            return (float) (vistaRadio + manoRadio * Math.sin(angulo));
        }
        private float getY(float vistaRadio, float manoRadio, double angulo) {
            return (float) (vistaRadio - manoRadio * Math.cos(angulo));
        }

        private void dibujarUna(Canvas canvas) {
            float vistaRadio = getHeight() / 2f;
            float unaRadio = getHeight() * 0.02f;
            canvas.drawCircle(vistaRadio, vistaRadio, unaRadio, ManesillaPintura);
        }

        private double getAnguloHora() {
            Calendar c = Calendar.getInstance();
            int horas = c.get(Calendar.HOUR);
            int minutos = c.get(Calendar.MINUTE);
            int minutosInicio = horas * 60 + minutos;
            return (2 * Math.PI * minutosInicio) / 720; //Minutos en 12 horas
        }
        private double getAnguloMinutos() {
            Calendar c = Calendar.getInstance();
            int segundosDesdeElInicio = c.get(Calendar.MINUTE) * 60  + c.get(Calendar.SECOND);
            return (2 * Math.PI * segundosDesdeElInicio) / 3600; // Divide los segundos en una hora
        }

        private double getAnguloSegundos() {
            Calendar c = Calendar.getInstance();
            int millisFromStart = c.get(Calendar.SECOND) * 1000 + c.get(Calendar.MILLISECOND);
            return (2 * Math.PI * millisFromStart) / 60000; // Milisegundos en 1 mnuto
        }
    }

}
