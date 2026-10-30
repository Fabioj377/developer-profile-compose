package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    DeveloperProfile(
                        name = "Fabio Jorge",
                        role = "Développeur junior",
                        bio = "Étudiant en informatique, passionné par le développement web et mobile. J’aime créer des applications modernes et découvrir de nouvelles technologies.",
                        skills = listOf(
                            "Kotlin",
                            "React",
                            "TypeScript"
                        ),
                        available = "Disponible pour une alternance",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun DeveloperProfile(
    name: String,
    role: String,
    bio: String,
    skills: List<String>,
    available: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        ProfileHeader(
            name = name,
            role = role
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        ProfileBio(
            bio = bio
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        SkillsSection(
            skills = skills
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        AvailabilityText(
            available = available
        )

        ContactButton(
            onClick = { }
        )
    }
}


@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = role
        )
    }
}


@Composable
fun ProfileBio(
    bio: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = bio,
        modifier = modifier
    )
}


@Composable
fun SkillsSection(
    skills: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        Text(
            text = "Compétences",
            fontWeight = FontWeight.Bold
        )

        skills.forEach { skill ->
            Text(
                text = "• $skill"
            )
        }
    }
}


@Composable
fun AvailabilityText(
    available: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = available,
        modifier = modifier
    )
}


@Composable
fun ContactButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = "Me contacter"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DeveloperProfilePreview() {
    MyApplicationTheme {
        DeveloperProfile(
            name = "Fabio Jorge",
            role = "Développeur junior",
            bio = "Étudiant en informatique, passionné par le développement web et mobile. J’aime créer des applications modernes et découvrir de nouvelles technologies.",
            skills = listOf(
                "Kotlin",
                "React",
                "TypeScript"
            ),
            available = "Disponible pour une alternance"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DeveloperProfilePreviewSecond() {
    MyApplicationTheme {
        DeveloperProfile(
            name = "Alice Martin",
            role = "Développeuse Android",
            bio = "Développeuse passionnée par la création d’applications mobiles simples et accessibles.",
            skills = listOf(
                "Kotlin",
                "Jetpack Compose",
                "Git"
            ),
            available = "Disponible pour un stage"
        )
    }
}