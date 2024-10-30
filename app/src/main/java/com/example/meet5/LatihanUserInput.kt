package com.example.meet5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview as Preview


@Preview(showBackground = true)
@Composable
fun LatihanUserInput(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var datanama by remember { mutableStateOf("") }
    var dataemail by remember { mutableStateOf("") }
    var datanoHp by remember { mutableStateOf("") }
    var dataalamat by remember { mutableStateOf("") }

    var jenisKelamin by remember { mutableStateOf("") }
    var datajenisKelamin by remember { mutableStateOf("") }
    val datajk = listOf("Laki-Laki","Perempuan")
    Column(modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }
        )
        Row {
            datajk.forEach { selectedJK ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = jenisKelamin == selectedJK,
                        onClick = {
                            jenisKelamin = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }
        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )
        TextField(
            value = noHp,
            onValueChange = {noHp = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Nomer Handphone")
            },
            placeholder = {
                Text("Masukkan Nomer Handphone Anda")
            }
            , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Alamat")
            },
            placeholder = {
                Text("Masukkan Alamat Anda")
            }
        )
        Button(onClick = {datanama = nama
            dataemail = email
            datanoHp = noHp
            dataalamat = alamat
            datajenisKelamin = jenisKelamin
                         },modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Simpan")
        }
        Card(modifier=Modifier.fillMaxWidth().padding(16.dp)) {
            Column {
                TampilData(judul = "Nama",
                            isinya = datanama
                )
                TampilData(judul = "Jenis Kelamin",
                    isinya = datajenisKelamin
                )
                TampilData(judul = "Email",
                    isinya = dataemail
                )
                TampilData(judul = "Nomer HP",
                    isinya = datanoHp
                )
                TampilData(judul = "Alamat",
                    isinya = dataalamat
                )
            }
        }
    }
}
@Composable
fun TampilData(
    judul:String,
    isinya:String
){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
        }
}