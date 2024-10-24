const API_URL = "http://localhost:8080/api/doctors";
const SPECIALITY_URL = "http://localhost:8080/api/specialities";

document.addEventListener("DOMContentLoaded", function () {
	const doctorForm = document.getElementById("doctorForm");
	const doctorTable = document
		.getElementById("doctorTable")
		.getElementsByTagName("tbody")[0];
	const specialitySelect = document.getElementById("speciality");

	fetchDoctors();
	fetchSpecialities();

	doctorForm.addEventListener("submit", function (e) {
		e.preventDefault();
		const id = document.getElementById("doctorId").value;
		console.log(" id en el hidden -----", id);
		const name = document.getElementById("name").value;
		const lastname = document.getElementById("lastname").value;
		const speciality = specialitySelect.value;

		const doctorData = {
			id,
			name,
			lastname,
			speciality,
		};

		if (id) {
			updateDoctor(id, doctorData);
		} else {
			createDoctor(doctorData);
		}
	});

	function fetchDoctors() {
		fetch(API_URL)
			.then((response) => response.json())
			.then((doctors) => {
				doctorTable.innerHTML = "";
				console.log(
					"Doctores recibidos:",
					JSON.stringify(doctors, null, 2)
				);
				doctors.forEach((doctor) => {
					console.log(
						"id doctor en foreach ",
						JSON.stringify(doctors.id)
					);
					const row = doctorTable.insertRow();
					row.innerHTML = `
                        <td>${doctor.name}</td>
                        <td>${doctor.lastname}</td>
                        <td>${doctor.speciality}</td>
                        <td>
                            <button onclick="editDoctor(${doctor.id})" >Editar</button>
                            <button onclick="deleteDoctor(${doctor.id})" >Eliminar</button>
                        </td>
                    `;
				});
			})
			.catch((error) => console.error("Error fetching doctors:", error));
	}

	function fetchSpecialities() {
		fetch(SPECIALITY_URL)
			.then((response) => response.json())
			.then((specialities) => {
				specialitySelect.innerHTML =
					'<option value="">Seleccione una especialidad</option>';
				specialities.forEach((speciality) => {
					const option = document.createElement("option");
					option.value = speciality;
					option.textContent = speciality;
					specialitySelect.appendChild(option);
				});
			})
			.catch((error) =>
				console.error("Error fetching specialities:", error)
			);
	}

	function createDoctor(doctor) {
		fetch(API_URL, {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(doctor),
		})
			.then((response) => response.json())
			.then(() => {
				fetchDoctors();
				doctorForm.reset();
			})
			.catch((error) => console.error("Error creating doctor:", error));
	}

	function updateDoctor(id, doctor) {
		fetch(`${API_URL}/${id}`, {
			method: "PUT",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(doctor),
		})
			.then((response) => {
				if (!response.ok) {
					throw new Error("Error updating doctor");
				}
				return response.json();
			})
			.then(() => {
				fetchDoctors();
				doctorForm.reset();
			})
			.catch((error) => {
				console.error("Error updating doctor:", error);
				alert(
					"Error al actualizar el doctor. Por favor, inténtalo de nuevo."
				);
			});
	}

	window.editDoctor = editDoctor;
	window.deleteDoctor = deleteDoctor;

	function editDoctor(id) {
		console.log("ID " + id);
		fetch(`${API_URL}/${id}`)
			.then((response) => response.json())
			.then((doctor) => {
				console.log(
					"DPCTOR PARA EDITAR!  ",
					id,
					JSON.stringify(doctor)
				);
				document.getElementById("doctorId").value = id;
				document.getElementById("name").value = doctor.name;
				document.getElementById("lastname").value = doctor.lastname;
				console.log(
					"COnsole log de speciality: ",
					(specialitySelect.value = doctor.speciality)
				);
				specialitySelect.value = doctor.speciality;
			})
			.catch((error) => {
				console.error("Error fetching doctor:", error);
				alert(
					"Error al obtener los datos del doctor. Por favor, inténtalo de nuevo."
				);
			});
	}

	function deleteDoctor(id) {
		if (confirm("¿Estás seguro de que quieres eliminar este doctor?")) {
			fetch(`${API_URL}/${id}`, {
				method: "DELETE",
			})
				.then((response) => {
					if (!response.ok) {
						throw new Error("Error al eliminar doctor");
					}
					return response.json();
				})
				.then(() => {
					fetchDoctors();
				})
				.catch((error) => {
					console.error("Error deleting doctor:", error);
					alert(
						"Error al eliminar el doctor. Por favor, inténtalo de nuevo."
					);
				});
		}
	}
});
