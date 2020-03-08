import Model.GeneroMusica;
import Model.Musica;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.RandomAccess;

public class ManipuladorMusica {
    private File arquivo;
    private ArrayList<GeneroMusica> generos;

    public ManipuladorMusica(File arquivo) {
        generos = new ArrayList<GeneroMusica>();
        generos.add(new GeneroMusica(0, "Blues"));
        generos.add(new GeneroMusica(1, "Classic Rock"));
        generos.add(new GeneroMusica(2, "Country"));
        generos.add(new GeneroMusica(3, "Dance"));
        generos.add(new GeneroMusica(4, "Disco"));
        generos.add(new GeneroMusica(5, "Funk"));
        generos.add(new GeneroMusica(6, "Grunge"));
        generos.add(new GeneroMusica(7, "Hip-Hop"));
        generos.add(new GeneroMusica(8, "Jazz"));
        generos.add(new GeneroMusica(9, "Metal"));
        generos.add(new GeneroMusica(10, "New GeneroMusica Age"));
        generos.add(new GeneroMusica(11, "Oldies"));
        generos.add(new GeneroMusica(12, "Other"));
        generos.add(new GeneroMusica(13, "Pop"));
        generos.add(new GeneroMusica(14, "R&B"));
        generos.add(new GeneroMusica(15, "Rap"));
        generos.add(new GeneroMusica(16, "Reggae"));
        generos.add(new GeneroMusica(17, "Rock"));
        generos.add(new GeneroMusica(18, "Techno"));
        generos.add(new GeneroMusica(19, "Industrial"));
        generos.add(new GeneroMusica(20, "Alternative"));
        generos.add(new GeneroMusica(21, "Ska"));
        generos.add(new GeneroMusica(22, "Death Metal"));
        generos.add(new GeneroMusica(23, "Pranks"));
        generos.add(new GeneroMusica(24, "Soundtrack"));
        generos.add(new GeneroMusica(25, "Euro-Techno"));
        generos.add(new GeneroMusica(26, "Ambient"));
        generos.add(new GeneroMusica(27, "Trip-Hop"));
        generos.add(new GeneroMusica(28, "Vocal"));
        generos.add(new GeneroMusica(29, "Jazz+Funk"));
        generos.add(new GeneroMusica(30, "Fusion"));
        generos.add(new GeneroMusica(31, "Trance"));
        generos.add(new GeneroMusica(32, "Classical"));
        generos.add(new GeneroMusica(33, "Instrumental"));
        generos.add(new GeneroMusica(34, "Acid"));
        generos.add(new GeneroMusica(35, "House"));
        generos.add(new GeneroMusica(36, "Game"));
        generos.add(new GeneroMusica(37, "Sound Clip"));
        generos.add(new GeneroMusica(38, "Gospel"));
        generos.add(new GeneroMusica(39, "Noise"));
        generos.add(new GeneroMusica(40, "AlternRock"));
        generos.add(new GeneroMusica(41, "Bass"));
        generos.add(new GeneroMusica(42, "Soul"));
        generos.add(new GeneroMusica(43, "Punk"));
        generos.add(new GeneroMusica(44, "Space"));
        generos.add(new GeneroMusica(45, "Meditative"));
        generos.add(new GeneroMusica(46, "Instrumental"));
        generos.add(new GeneroMusica(47, "Instrumental Rock"));
        generos.add(new GeneroMusica(48, "Ethnic"));
        generos.add(new GeneroMusica(49, "Gothic"));
        generos.add(new GeneroMusica(50, "Darkwave"));
        generos.add(new GeneroMusica(51, "Techno-Industrial"));
        generos.add(new GeneroMusica(52, "Electronic"));
        generos.add(new GeneroMusica(53, "Pop-Folk"));
        generos.add(new GeneroMusica(54, "Eurodance"));
        generos.add(new GeneroMusica(55, "Dream"));
        generos.add(new GeneroMusica(56, "Southern Rock"));
        generos.add(new GeneroMusica(57, "Comedy"));
        generos.add(new GeneroMusica(58, "Cult"));
        generos.add(new GeneroMusica(59, "Gangsta"));
        generos.add(new GeneroMusica(60, "Top 40"));
        generos.add(new GeneroMusica(61, "Christian Rap"));
        generos.add(new GeneroMusica(62, "Pop/Funk"));
        generos.add(new GeneroMusica(63, "Jungle"));
        generos.add(new GeneroMusica(64, "Native American"));
        generos.add(new GeneroMusica(65, "Cabaret"));
        generos.add(new GeneroMusica(66, "New GeneroMusica Wave"));
        generos.add(new GeneroMusica(67, "Psychadelic"));
        generos.add(new GeneroMusica(68, "Rave"));
        generos.add(new GeneroMusica(69, "Showtunes"));
        generos.add(new GeneroMusica(70, "Trailer"));
        generos.add(new GeneroMusica(71, "Lo-Fi"));
        generos.add(new GeneroMusica(72, "Tribal"));
        generos.add(new GeneroMusica(73, "Acid Punk"));
        generos.add(new GeneroMusica(74, "Acid Jazz"));
        generos.add(new GeneroMusica(75, "Polka"));
        generos.add(new GeneroMusica(76, "Retro"));
        generos.add(new GeneroMusica(77, "Musical"));
        generos.add(new GeneroMusica(78, "Rock & Roll"));
        generos.add(new GeneroMusica(79, "Hard Rock"));
        setArquivo(arquivo);
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public Musica lerMusica() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(arquivo, "r");
        long length = raf.length();
        raf.seek(length - 128);
        byte[] byteArray = new byte[3];
        raf.read(byteArray);
        String tag = new String(byteArray);

        if(!"TAG".equals(tag)){
            return null;
        }

        Musica musica = new Musica();

        byteArray = new byte[30];
        raf.read(byteArray);

        musica.setTituloMusica(new String(byteArray));
        raf.read(byteArray);
        musica.setArtista(new String(byteArray));
        raf.read(byteArray);
        musica.setAlbum(new String(byteArray));

        byteArray = new byte[4];
        raf.read(byteArray);
        musica.setAno(new String(byteArray));

        byteArray = new byte[28];
        raf.read(byteArray);
        musica.setComentario(new String(byteArray));

        byteArray = new byte[1];
        raf.read(byteArray);
        musica.setFlagTrilha(Byte.valueOf(byteArray[0]).intValue());

        raf.read(byteArray);
        musica.setNumeroFaixa(Byte.valueOf(byteArray[0]).intValue());

        raf.read(byteArray);
        musica.setGenero(generos.get(Byte.valueOf(byteArray[0]).intValue()));

        return musica;
    }
    
//    public boolean salvarMusica(){
//
//    }
//
//    private static void writeToFile(String filePath, String data, int position)
//            throws IOException {
//        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
//        file.seek(position);
//        file.write(data.getBytes());
//        file.close();
//    }

}
