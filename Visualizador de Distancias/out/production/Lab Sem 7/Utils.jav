public class Utils {
    public static List<Distancia> lerCidades(String nomeArquivo) throws IOException {
        List<Distancia> distancias = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                String origem = campos[0];
                String destino = campos[1];
                double dist = Double.parseDouble(campos[2]);
                distancias.add(new Distancia(origem, destino, dist));
            }
        }
        
        return distancias;
    }
}
