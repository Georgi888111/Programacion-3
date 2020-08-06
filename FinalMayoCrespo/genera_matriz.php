<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultados</title>
    </head>
    <body>
       <?php
        $numero = $_POST['numero'];

        $matriz;
        $sumc = [];
        $ultima;
        $aux;


        if ($numero % 2 == 0) {
            echo "No es un número impar";
        } else {
            for ($i = 1; $i <= $numero; $i++) {

                for ($j = 1; $j <= $numero; $j++) {
                    $matriz[$i][$j] = $i * $j;
                }
            }

            for ($j = 1; $j <= $numero; $j++) {
                $cont = 0;
                for ($i = 1; $i < $numero; $i++) {
                    $cont += $matriz[$j][$i];
                }
                $ultima[$j] = $cont;
            }
            echo "<table>";
            for ($i = 1; $i <= $numero; $i++) {
                echo "<tr>";
                for ($j = 1; $j <= $numero; $j++) {
                    echo "<td>";
                    if ($i == $numero) {
                        echo $ultima[$j] . " ";
                    } else {
                        echo $matriz[$i][$j] . " ";
                    }
                    echo "</td>";
                }

                echo "</tr>";
            }
            echo "</table>";
        }
        ?>
    </body>
</html>

 