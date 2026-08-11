import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class FilePacker
{
    public static void main(String A[])
    {
        JFrame frame = new JFrame("File Packer Application");

        JLabel folderLabel = new JLabel("Enter Folder Name : ");
        folderLabel.setBounds(50, 50, 150, 30);

        JTextField folderTextField = new JTextField();
        folderTextField.setBounds(200, 50, 150, 30);

        JLabel fileLabel = new JLabel("Enter File Name : ");
        fileLabel.setBounds(50, 100, 150, 30);

        JTextField fileTextField = new JTextField();
        fileTextField.setBounds(200, 100, 150, 30);

        JButton packButton = new JButton("Pack Files");
        packButton.setBounds(150, 150, 150, 30);

        frame.setLayout(null);

        frame.add(folderLabel);
        frame.add(folderTextField);
        frame.add(fileLabel);
        frame.add(fileTextField);
        frame.add(packButton);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        packButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int iRet = 0;
                int Size = 0;
                int i = 0;
                int j = 0;

                String FolderName = folderTextField.getText();
                String PackFileName = fileTextField.getText();

                String header = "";

                FileOutputStream foobj = null;
                FileInputStream fiobj = null;

                byte Buffer[] = new byte[1024];
                byte bHeader[] = null;

                File fobjfolder = new File(FolderName);

                if((fobjfolder.exists()) && (fobjfolder.isDirectory()))
                {
                    System.out.println("Folder exists");

                    try
                    {
                        File fobjpack = new File(PackFileName);

                        fobjpack.createNewFile();

                        foobj = new FileOutputStream(fobjpack);

                        File fArr[] = fobjfolder.listFiles();

                        System.out.println(
                            "Number of files in folder : " + fArr.length
                        );

                        for(i = 0; i < fArr.length; i++)
                        {
                            if(fArr[i].isFile())
                            {
                                fiobj = new FileInputStream(fArr[i]);

                                header = fArr[i].getName();
                                header = header + " ";
                                header = header + fArr[i].length();

                                Size = 100 - header.length();

                                for(j = 1; j <= Size; j++)
                                {
                                    header = header + " ";
                                }

                                bHeader = header.getBytes();

                                // Write header
                                foobj.write(bHeader);

                                // Write file data
                                while((iRet = fiobj.read(Buffer)) != -1)
                                {
                                    for(int k = 0; k < iRet; k++)
                                    {
                                        Buffer[k] = (byte)(Buffer[k] ^ 'A');
                                    }
                                    foobj.write(Buffer, 0, iRet);
                                }

                                fiobj.close();

                                header = "";
                            }
                        }

                        foobj.close();

                        JOptionPane.showMessageDialog(
                            frame,
                            "Files Packed Successfully..!"
                        );
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(
                            frame,
                            "Error : " + ex.getMessage()
                        );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(
                        frame,
                        "There is no such folder..!"
                    );
                }
            }
        });
    }
}