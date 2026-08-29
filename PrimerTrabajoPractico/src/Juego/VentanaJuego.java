package Juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class VentanaJuego extends JFrame implements ObservadorJuego {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// campos que faltaban declarar - por eso los otros metodos no los encontraban
	private JLabel labelPuntaje;
	private JLabel labelProximaFicha;
	private JLabel[][] celdasVisuales;
	private Juego juego;
	private boolean finDePartidaMostrado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		setFont(new Font("Arial Black", Font.BOLD, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // pequeño espacio entre celdas
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		
		JLabel celda0 = new JLabel("00");
		celda0.setHorizontalAlignment(SwingConstants.CENTER);
		celda0.setOpaque(true);                    // ¡para que se vea el fondo!
		celda0.setBackground(new Color(192, 192, 192));
		celda0.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda0);
		
		JLabel celda1 = new JLabel("01");
		celda1.setHorizontalAlignment(SwingConstants.CENTER);
		celda1.setOpaque(true);                    // ¡para que se vea el fondo!
		celda1.setBackground(new Color(192, 192, 192));
		celda1.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda1);
		
		JLabel celda2 = new JLabel("02");
		celda2.setHorizontalAlignment(SwingConstants.CENTER);
		celda2.setOpaque(true);                    // ¡para que se vea el fondo!
		celda2.setBackground(new Color(192, 192, 192));
		celda2.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda2);
		
		JLabel celda3 = new JLabel("03");
		celda3.setHorizontalAlignment(SwingConstants.CENTER);
		celda3.setOpaque(true);                    // ¡para que se vea el fondo!
		celda3.setBackground(new Color(192, 192, 192));
		celda3.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda3);
		
		JLabel celda4 = new JLabel("04");
		celda4.setHorizontalAlignment(SwingConstants.CENTER);
		celda4.setOpaque(true);                    // ¡para que se vea el fondo!
		celda4.setBackground(new Color(192, 192, 192));
		celda4.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda4);
		
		JLabel celda5 = new JLabel("05");
		celda5.setHorizontalAlignment(SwingConstants.CENTER);
		celda5.setOpaque(true);                    // ¡para que se vea el fondo!
		celda5.setBackground(new Color(192, 192, 192));
		celda5.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda5);
		
		JLabel celda6 = new JLabel("06");
		celda6.setHorizontalAlignment(SwingConstants.CENTER);
		celda6.setOpaque(true);                    // ¡para que se vea el fondo!
		celda6.setBackground(new Color(192, 192, 192));
		celda6.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda6);
		
		JLabel celda7 = new JLabel("07");
		celda7.setHorizontalAlignment(SwingConstants.CENTER);
		celda7.setOpaque(true);                    // ¡para que se vea el fondo!
		celda7.setBackground(new Color(192, 192, 192));
		celda7.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda7);
		
		JLabel celda8 = new JLabel("08");
		celda8.setHorizontalAlignment(SwingConstants.CENTER);
		celda8.setOpaque(true);                    // ¡para que se vea el fondo!
		celda8.setBackground(new Color(192, 192, 192));
		celda8.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda8);
		
		JLabel celda9 = new JLabel("09");
		celda9.setHorizontalAlignment(SwingConstants.CENTER);
		celda9.setOpaque(true);                    // ¡para que se vea el fondo!
		celda9.setBackground(new Color(192, 192, 192));
		celda9.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda9);
		
		JLabel celda10 = new JLabel("10");
		celda10.setHorizontalAlignment(SwingConstants.CENTER);
		celda10.setOpaque(true);                    // ¡para que se vea el fondo!
		celda10.setBackground(new Color(192, 192, 192));
		celda10.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda10);
		
		JLabel celda11 = new JLabel("11");
		celda11.setHorizontalAlignment(SwingConstants.CENTER);
		celda11.setOpaque(true);                    // ¡para que se vea el fondo!
		celda11.setBackground(new Color(192, 192, 192));
		celda11.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda11);
		
		JLabel celda12 = new JLabel("12");
		celda12.setHorizontalAlignment(SwingConstants.CENTER);
		celda12.setOpaque(true);                    // ¡para que se vea el fondo!
		celda12.setBackground(new Color(192, 192, 192));
		celda12.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda12);
		
		JLabel celda13 = new JLabel("13");
		celda13.setHorizontalAlignment(SwingConstants.CENTER);
		celda13.setOpaque(true);                    // ¡para que se vea el fondo!
		celda13.setBackground(new Color(192, 192, 192));
		celda13.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda13);
		
		JLabel celda14 = new JLabel("14");
		celda14.setHorizontalAlignment(SwingConstants.CENTER);
		celda14.setOpaque(true);                    // ¡para que se vea el fondo!
		celda14.setBackground(new Color(192, 192, 192));
		celda14.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda14);
		
		JLabel celda15 = new JLabel("15");
		celda15.setHorizontalAlignment(SwingConstants.CENTER);
		celda15.setOpaque(true);                    // ¡para que se vea el fondo!
		celda15.setBackground(new Color(192, 192, 192));
		celda15.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(celda15);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		labelPuntaje = new JLabel("0");
		labelPuntaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(labelPuntaje);
		
		labelProximaFicha = new JLabel("-");
		labelProximaFicha.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(labelProximaFicha);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton botonReiniciar = new JButton("Reiniciar (R)");
		botonReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarJuego();
			}
		});
		panel_2.add(botonReiniciar);

		celdasVisuales = new JLabel[][] {
            { celda0,  celda1,  celda2,  celda3  },
            { celda4,  celda5,  celda6,  celda7  },
            { celda8,  celda9,  celda10, celda11 },
            { celda12, celda13, celda14, celda15 }
        };

        juego = new Juego();
        juego.registrarObservador(this);

        addKeyListener(new CapturaTeclas(juego));
        setFocusable(true);

        actualizarVista();
    }

    public void notificar(Juego juego) {
        actualizarVista();
    }

    private void reiniciarJuego() {
        juego.reiniciar();
        finDePartidaMostrado = false;
    }

    private void actualizarVista() {
        Tablero tablero = juego.getTablero();

        for (int f = 0; f < tablero.getFilas(); f++) {
            for (int c = 0; c < tablero.getColumnas(); c++) {
                Ficha ficha = tablero.getFicha(f, c);
                JLabel celda = celdasVisuales[f][c];

                if (ficha == null) {
                    celda.setText("");
                    celda.setBackground(Color.LIGHT_GRAY);
                } else {
                    celda.setText(String.valueOf(ficha.getValor()));
                    celda.setBackground(colorParaValor(ficha.getValor()));
                }
            }
        }

        labelPuntaje.setText("Puntaje: " + juego.getPuntaje());

        Ficha proxima = juego.getProximaFicha();
        String texto = (proxima == null) ? "-" : String.valueOf(proxima.getValor());
        labelProximaFicha.setText("Próxima ficha: " + texto);

        if (juego.estaTerminado() && !finDePartidaMostrado) {
            finDePartidaMostrado = true;
            JOptionPane.showMessageDialog(this,
                "Juego terminado. Puntaje final: " + juego.getPuntaje(),
                "Fin de la partida",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Color colorParaValor(int valor) {
        switch (valor) {
            case 1: return new Color(238, 228, 218);
            case 2: return new Color(255, 182, 76);
            case 3: return new Color(255, 140, 20);
            case 6: return new Color(255, 100, 100);
            case 12: return new Color(255, 60, 60);
            case 24: return new Color(237, 204, 97);
            case 48: return new Color(237, 197, 63);
            default: return new Color(60, 58, 50);
        }
    
		
	}


}
