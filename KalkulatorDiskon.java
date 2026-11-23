import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorDiskon {
    public static void main(String[] args) {
        // 1. Top-level Container
        JFrame frame = new JFrame("Kalkulator Diskon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new BorderLayout(10, 10));          // Layout 1: BorderLayout

        // 3. Atomic Component
        JLabel judul = new JLabel("Kalkulator Diskon Belanja", SwingConstants.CENTER);
        JLabel lblHarga = new JLabel("Harga (Rp):");
        JTextField txtHarga = new JTextField();
        JLabel lblDiskon = new JLabel("Diskon (%):");
        JTextField txtDiskon = new JTextField();
        JLabel lblPotongan = new JLabel("Potongan:");
        JLabel hasilPotongan = new JLabel("-");
        JLabel lblAkhir = new JLabel("Harga Akhir:");
        JLabel hasilAkhir = new JLabel("-");
        JButton btnHitung = new JButton("Hitung");
        JButton btnReset = new JButton("Reset");

        // 2. Intermediate Container + Layout 2: GridLayout
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 5, 5));
        panelForm.add(lblHarga);
        panelForm.add(txtHarga);
        panelForm.add(lblDiskon);
        panelForm.add(txtDiskon);
        panelForm.add(lblPotongan);
        panelForm.add(hasilPotongan);
        panelForm.add(lblAkhir);
        panelForm.add(hasilAkhir);

        // 2. Intermediate Container + Layout 3: FlowLayout
        JPanel panelTombol = new JPanel(new FlowLayout());
        panelTombol.add(btnHitung);
        panelTombol.add(btnReset);

        // 5. Event Listener (interface): ActionListener -> tombol Hitung
        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double harga = Double.parseDouble(txtHarga.getText());
                    double diskon = Double.parseDouble(txtDiskon.getText());
                    double potongan = harga * diskon / 100;
                    double akhir = harga - potongan;
                    hasilPotongan.setText("Rp " + potongan);
                    hasilAkhir.setText("Rp " + akhir);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Isi harga dan diskon dengan angka!");
                }
            }
        });

        // 5. Event Listener (adapter class): MouseAdapter -> tombol Reset
        btnReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtHarga.setText("");
                txtDiskon.setText("");
                hasilPotongan.setText("-");
                hasilAkhir.setText("-");
            }
        });

        frame.add(judul, BorderLayout.NORTH);
        frame.add(panelForm, BorderLayout.CENTER);
        frame.add(panelTombol, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
